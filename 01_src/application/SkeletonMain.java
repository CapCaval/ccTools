package application;

import info.clearthought.layout.TableLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import application.SkeletonView.Position;
import application.annotation.OmiSubPanel;
import application.annotation.OMI;
import application.annotation.SkeletonItem;
import application.annotation.Skeleton;
import application.annotation.SkeletonLayout;
import application.extendedpanel.ExtendedPanel;
import application.tool.pair.Pair;
import application.tool.pair.PairFactory;

public class SkeletonMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		OmiFrame f = new OmiFrame();

		computeOmi(f);

		f.setVisible(true);
	}

	private static void computeOmi(OmiFrame f) {

		Class<?> omiType = f.getClass();

		OMI omiAnnotation = omiType.getAnnotation(OMI.class);
		boolean present = omiType.isAnnotationPresent(OMI.class);
		System.out.println(omiAnnotation + "   present : " + present);

		if (present) {
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setBounds(omiAnnotation.x(), omiAnnotation.y(), omiAnnotation.width(), omiAnnotation.height());
			f.setTitle(omiAnnotation.name());

			// get the skeleton
			JPanel skeleton = getSkeleton(f);
			f.getContentPane().add(skeleton);

			// retrieve all the panel of the skeleton
			Map<SkeletonView.Position, ExtendedPanel> skeletonItems = computeSkeleton(skeleton);

			// retrieve all the panel to be inserted inside the skeleton
			List<Pair<SkeletonView.Position, ExtendedPanel>> pairList = computeOmiContents(f);

			// put all the panel inside the skeleton
			for (Pair<SkeletonView.Position, ExtendedPanel> pair : pairList) {
				// get the pos inside the skeleton
				Position pos = pair.firstItem();
				// retrieve the skeleton component at the given id
				ExtendedPanel ePanel = skeletonItems.get(pos);
				
				// check out if it is a tabbed pane
				if( ePanel.getTabbedPanel() != null){
					ExtendedPanel applicationPanel = pair.secondItem();
					ePanel.getTabbedPanel().addTab(applicationPanel.getLabel(), applicationPanel.getPanel());
				}
				else{ //else just add it
					// add the omi panel inside the skeleton
					ePanel.getPanel().add(pair.secondItem().getPanel(), BorderLayout.CENTER);
				}
			}

		}
	}


	private static List<Pair<Position, ExtendedPanel>> computeOmiContents(OmiFrame f) {

		List<Pair<Position, ExtendedPanel>> omiItems = new ArrayList<Pair<Position, ExtendedPanel>>();
		Class<?> omiType = f.getClass();

		for (Field field : omiType.getDeclaredFields()) {
			if (field.isAnnotationPresent(OmiSubPanel.class)) {
				JPanel panel = null;
				try {
					panel = (JPanel) field.get(f);
				} catch (Exception e) {
					e.printStackTrace();
				}

				// retrieve the position and use it as a key
				OmiSubPanel annotation = field.getAnnotation(OmiSubPanel.class);
				
				ExtendedPanel ePanel = ExtendedPanel.factory.createExtendedPanel(panel, annotation.name());

				omiItems.add(PairFactory.factory.newPair(annotation.value(),
						ePanel));
			}
		}

		return omiItems;
	}

	private static Map<Position, ExtendedPanel> computeSkeleton(JPanel skeleton) {
		Class<?> skeletonType = skeleton.getClass();

		if (skeletonType.isAnnotationPresent(SkeletonLayout.class)) {

			// retrieve the skeleton annotation
			SkeletonLayout layoutInfo = skeletonType.getAnnotation(SkeletonLayout.class);
			
			// retrieve the colmns and rows layout config
			double[][] size = {layoutInfo.columnsSize(), layoutInfo.rowSize()};

			// apply the table layout to the skeleton with the configure size
			skeleton.setLayout(new TableLayout(size));
		}

		Map<SkeletonView.Position, ExtendedPanel> skeletonItems = new HashMap<SkeletonView.Position, ExtendedPanel>();

		for (Field field : skeletonType.getDeclaredFields()) {
			if (field.isAnnotationPresent(SkeletonItem.class)) {
				JPanel panel = null;
				try {
					panel = (JPanel) field.get(skeleton);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
//				panel.setBorder(new LineBorder(Color.RED));
				panel.setLayout(new BorderLayout());
				
				// retrieve the position and use it as a key
				SkeletonItem annotation = field
						.getAnnotation(SkeletonItem.class);

				boolean isTabbedpanel = annotation.tabpane();
				Image icon = null;
				boolean isResizeable = false;
				JTabbedPane tabbedPanel = null;
				
				
//				// check out if a tab pane is required 
				if(isTabbedpanel){
					tabbedPanel = new JTabbedPane();
					
					// create a tab pane
					panel.add(tabbedPanel, BorderLayout.CENTER);
				}
				// apply the layout
				skeleton.add(panel, annotation.gridPosition());
				//wrap the values inside an extended panel
				ExtendedPanel ePanel = ExtendedPanel.factory.createExtendedPanel(panel, tabbedPanel, icon, isResizeable);
				
				// store it 
				skeletonItems.put(annotation.pos(), ePanel);
			}
		}

		return skeletonItems;
	}

	private static JPanel getSkeleton(OmiFrame f) {

		Class<?> omiType = f.getClass();

		for (Field field : omiType.getDeclaredFields()) {
			if (field.isAnnotationPresent(Skeleton.class)) {
				JPanel skeleton = null;
				try {
					skeleton = (JPanel) field.get(f);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return skeleton;
			}
		}
		return null;
	}

}
