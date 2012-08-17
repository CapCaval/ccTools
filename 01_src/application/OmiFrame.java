package application;

import javax.swing.JFrame;

import application.annotation.OmiSubPanel;
import application.annotation.OMI;
import application.annotation.Skeleton;

@OMI(
		name = "Skeleton test", 
		x = 10, y = 15, 
		width = 1280, height = 1024)
public class OmiFrame extends JFrame {

	private static final long serialVersionUID = 8793555177476478487L;

	@Skeleton
	public SkeletonView skeleton = new SkeletonView();

	@OmiSubPanel(value = SkeletonView.Position.topCenter)
	GenericPanel p1 = new GenericPanel("topCenter");

	@OmiSubPanel(value = SkeletonView.Position.topLeftCorner)
	GenericPanel p2 = new GenericPanel("topLeftCorner");

	@OmiSubPanel(value = SkeletonView.Position.topRightCenter)
	GenericPanel p3 = new GenericPanel("topRightCenter");

	@OmiSubPanel(value = SkeletonView.Position.leftSide)
	GenericPanel p4 = new GenericPanel("leftSide");
	
	@OmiSubPanel(value = SkeletonView.Position.center, name = "First center")
	GenericPanel p5 = new GenericPanel("center");

	@OmiSubPanel(value = SkeletonView.Position.center, name = "Second center")
	GenericPanel p9 = new GenericPanel("center2");

	@OmiSubPanel(value = SkeletonView.Position.center, name = "Third center")
	GenericPanel p10 = new GenericPanel("center3");
	
	@OmiSubPanel(value = SkeletonView.Position.centerRightSide)
	GenericPanel p6 = new GenericPanel("centerRightSide");
	
	@OmiSubPanel(value = SkeletonView.Position.bottomCenter)
	GenericPanel p7 = new GenericPanel("bottomCenter");

	@OmiSubPanel(SkeletonView.Position.bottomRightCorner)
	GenericPanel p8 = new GenericPanel("bottomRightCorner");

}
