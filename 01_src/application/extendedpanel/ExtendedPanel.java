package application.extendedpanel;

import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public interface ExtendedPanel {
	public interface Factory {
		ExtendedPanel createExtendedPanel(JPanel panel);
		ExtendedPanel createExtendedPanel(JPanel panel, String label);
		ExtendedPanel createExtendedPanel(JPanel panel, JTabbedPane tabbedPane, Image icon, boolean isResizeable);
	}
	
	public static Factory factory = new FactoryImpl();
	
	public JPanel getPanel();
	public JTabbedPane getTabbedPanel();
	public String getLabel();
	public Image getIcon();
	public boolean isResizeable();
}
