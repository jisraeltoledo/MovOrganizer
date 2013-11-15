/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movorganizer.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Hexe
 */
public class FileTreePanel extends JPanel {

    JTree arbol;

    public FileTreePanel() {
        setLayout(new BorderLayout());
        arbol = new JTree(new FileTreeModel());
        arbol.setRootVisible(false);
        JScrollPane scroll = new JScrollPane(arbol);        
        add(scroll);
        
        arbol.addTreeSelectionListener( new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return arbol.getPreferredScrollableViewportSize();
    }
}

class FileTreeModel implements TreeModel {

    File[] unidades;

    public FileTreeModel() {
        unidades = File.listRoots();
    }

    @Override
    public Object getRoot() {
        return new Object();
    }

    @Override
    public Object getChild(Object parent, int index) {
        if (parent instanceof File) {
            File f = (File) parent;
            File[] files = f.listFiles();
            Arrays.sort(files, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    if (o1.isDirectory() && o2.isFile()) {
                        return -1;
                    } else if (o2.isDirectory() && o1.isFile()) {
                        return 1;
                    } else {
                        return o1.compareTo(o2);
                    }
                }
            });
            return new FileTreeNode(files[index]);
        } else {
            return new FileTreeNode(unidades[index]);

        }
    }

    @Override
    public int getChildCount(Object parent) {
        if (parent instanceof File) {
            File f = (File) parent;
            File[] files = f.listFiles();
            if (files != null)
                return files.length;
            else
                return 0;
        } else {
            return unidades.length;
            
        }
    }

    @Override
    public boolean isLeaf(Object node) {
        if (node instanceof File) {
            File f = (File) node;
            if (f.isDirectory()) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;            
        }
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if (parent == null || child == null) {
            return -1;
        }
        if (parent instanceof File) {
            File f = (File) parent;
            File[] childs = f.listFiles();
            for (int i = 0; i < childs.length; i++) {
                if (childs[i].equals(child)) {
                    return i;
                }
            }
            return -1;
            
        } else {
            for (int i = 0; i < unidades.length; i++) {
                if (unidades[i].equals(child)) {
                    return i;
                }
            }
            return -1;
        }

    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
    }
}

class FileTreeNode  extends File{

    File f;
    public FileTreeNode(File f) {
        super (f.getPath());
        this.f = f;
    }

    @Override
    public String toString() {
        if (f.toPath().getNameCount() == 0) {
            return f.getPath();
        }
        return f.getName();
    }
}