package application;

import info.clearthought.layout.TableLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import application.annotation.SkeletonItem;
import application.annotation.SkeletonLayout;

@SkeletonLayout(
		columnsSize = {150, TableLayout.FILL, 200, 90},
		rowSize = {40, 40, TableLayout.FILL, 50, 100}
		)
public class SkeletonView extends JPanel{
	
	public enum Position{topLeftCorner, topCenter, topRightCenter, leftSide, center, centerRightSide, bottomCenter, bottomRightCorner};

	@SkeletonItem( pos=Position.topLeftCorner, gridPosition = "0, 0, 0, 1")
	JPanel topLeftCorner = new JPanel();

	@SkeletonItem( pos=Position.topCenter, gridPosition = "1, 0, 2,0")
	JPanel topCenter = new JPanel();

	@SkeletonItem( pos=Position.topRightCenter, gridPosition = "3,0")
	JPanel topRightCenter = new JPanel();

	@SkeletonItem( pos=Position.leftSide, gridPosition = "0, 2, 0, 4")
	JPanel leftSide = new JPanel();

	@SkeletonItem( pos=Position.center, gridPosition = "1, 1, 1, 4", tabpane = true)
	JPanel center = new JPanel();

	@SkeletonItem( pos=Position.centerRightSide, gridPosition = "2, 1, 3, 2")
	JPanel centerRightSide = new JPanel();

	@SkeletonItem( pos=Position.bottomCenter, gridPosition = "1, 4")
	JPanel bottomCenter = new JPanel();

	@SkeletonItem( pos=Position.bottomRightCorner, gridPosition = "2, 3, 3, 4")
	JPanel bottomRightCorner = new JPanel();

}
