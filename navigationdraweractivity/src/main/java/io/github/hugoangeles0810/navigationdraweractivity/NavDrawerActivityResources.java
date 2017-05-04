package io.github.hugoangeles0810.navigationdraweractivity;


import android.support.annotation.ArrayRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NavDrawerActivityResources {

    @MenuRes int navigationMenu();
    @LayoutRes int navigationHeaderLayout() default NavigationDrawerActivity.NO_NAVIGATION_HEADER_LAYOUT;
    @ArrayRes int arrayOfMenuItemIds();
    @ArrayRes int arrayOfActivityClasses();
    @IdRes int currentMenuItemId();

}
