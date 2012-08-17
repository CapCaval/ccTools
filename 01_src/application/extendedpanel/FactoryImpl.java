package application.extendedpanel;

import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import application.extendedpanel.ExtendedPanel.Factory;

public class FactoryImpl implements Factory {

	@Override
	public ExtendedPanel createExtendedPanel(JPanel panel) {
		return new ExtentedPanelImpl(panel, null, null, false, "");
	}

	@Override
	public ExtendedPanel createExtendedPanel(
			JPanel panel, JTabbedPane tabbedPane, 
			Image icon, boolean isResizeable) {
		return new ExtentedPanelImpl( panel, tabbedPane, icon, isResizeable, "");
	}

	@Override
	public ExtendedPanel createExtendedPanel(JPanel panel, String name) {
		return new ExtentedPanelImpl(panel, null, null, false, name);
	}


}
