package application.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//import application.SkeletonView.Position;


@Retention(RetentionPolicy.RUNTIME)
public @interface SkeletonItem {
//	Position pos();
	String gridPosition();
	boolean tabpane() default false;
}
