package application.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.swing.JPanel;

//import application.SkeletonView.Position;

@Retention(RetentionPolicy.RUNTIME)
public @interface OmiSubPanel {

//	Position value();
	String name() default "";
}
