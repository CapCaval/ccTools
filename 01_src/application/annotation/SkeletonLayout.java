package application.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SkeletonLayout {

	double[] columnsSize();
	double[] rowSize();

}
