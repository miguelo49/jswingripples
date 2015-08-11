package org.incha.ui.stats;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.SwingUtilities;

import org.incha.core.JavaProject;
import org.incha.core.jswingripples.eig.JSwingRipplesEIGNode;
import org.incha.ui.classview.ClassTreeView;

public class HierarchicalView extends ClassTreeView {
    private static final long serialVersionUID = -725916023414871313L;

    /**
     * Default constructor.
     */
    public HierarchicalView(final JavaProject project, final List<JSwingRipplesEIGNode> nodes) {
        super(project);
        setData(nodes);
        addMouseListener(new MouseAdapter() {
            /* (non-Javadoc)
             * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
             */
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    showPopupMenu(e.getX(), e.getY());
                }
            }
        });
    }

    /**
     * @param x x mouse coordinate.
     * @param y y mouse coordinate.
     */
    protected void showPopupMenu(final int x, final int y) {
        final JSwingRipplesEIGNode node = getSelectedItem(x, y);
        if (node != null) {
            ICActionsManager.getInstance().showMenuForNode(node, x, y, this);
        }
    }
}