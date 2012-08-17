package application.extendedpanel;

import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ExtentedPanelImpl implements ExtendedPanel {

	private Image icon;
	private String label;
	private boolean isResizeable;
	private JPanel panel;
	private JTabbedPane tabbedPane;

	public ExtentedPanelImpl(JPanel panel, JTabbedPane tabbedPane, Image icon, boolean isResizeable, String label) {
		this.panel = panel;
		this.isResizeable = isResizeable;
		this.icon = icon;
		this.tabbedPane = tabbedPane;
		this.label = label;
	}

	@Override
	public Image getIcon() {
		return this.icon;
	}

	@Override
	public String getLabel() {
		return this.label;
	}

	@Override
	public boolean isResizeable() {
		return this.isResizeable;
	}

	@Override
	public JPanel getPanel() {
		return this.panel;
	}

	@Override
	public JTabbedPane getTabbedPanel() {
		return this.tabbedPane;
	}

}
