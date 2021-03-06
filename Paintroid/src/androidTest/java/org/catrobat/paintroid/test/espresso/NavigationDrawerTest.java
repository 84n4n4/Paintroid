/**
 * Paintroid: An image manipulation application for Android.
 * Copyright (C) 2010-2015 The Catrobat Team
 * (<http://developer.catrobat.org/credits>)
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.catrobat.paintroid.test.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.catrobat.paintroid.MainActivity;
import org.catrobat.paintroid.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.close;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class NavigationDrawerTest {

	@Rule
	public ActivityTestRule<MainActivity> mActivityRule =
			new ActivityTestRule<>(MainActivity.class);

	@Test
	public void testNavigationDrawerOpenAndClose() {
		onView(withId(R.id.drawer_layout)).perform(open());
		onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
		onView(withId(R.id.drawer_layout)).perform(close());
	}

	@Test
	public void testNavigationDrawerAllItemsExist() {
		onView(withId(R.id.drawer_layout)).perform(open());
		onView(withText(R.string.menu_save_image)).check(matches(isDisplayed()));
		onView(withText(R.string.menu_save_copy)).check(matches(isDisplayed()));
		onView(withText(R.string.menu_load_image)).check(matches(isDisplayed()));
		onView(withText(R.string.menu_new_image)).check(matches(isDisplayed()));
		onView(withText(R.string.menu_hide_menu)).check(matches(isDisplayed()));
		onView(withText(R.string.menu_language)).check(matches(isDisplayed()));
		onView(withText(R.string.menu_terms_of_use_and_service)).check(matches(isDisplayed()));
		onView(withText(R.string.help_title)).check(matches(isDisplayed()));
		onView(withText(R.string.menu_about)).check(matches(isDisplayed()));
		onView(withId(R.id.drawer_layout)).perform(close());

	}

	@Test
	public void testNavigationDrawerItemHelpClick() {
		onView(withId(R.id.drawer_layout)).perform(open());
		onView(withText(R.string.help_title)).perform(click());
	}

	@Test
	public void testNavigationDrawerItemAboutClick() {
		onView(withId(R.id.drawer_layout)).perform(open());
		onView(withText(R.string.menu_about)).perform(click());
	}

	@Test
	public void testNavigationDrawerItemTermsOfUserClick() {
		onView(withId(R.id.drawer_layout)).perform(open());
		onView(withText(R.string.menu_terms_of_use_and_service)).perform(click());
	}

	@Test
	public void testNavigationDrawerItemFullScreenClick() {
		onView(withId(R.id.drawer_layout)).perform(open());
		onView(withText(R.string.menu_hide_menu)).perform(click());
		onView(withId(R.id.drawer_layout)).perform(open());
		onView(withText(R.string.menu_show_menu)).check(matches(isDisplayed()));
		onView(withText(R.string.menu_hide_menu)).check(doesNotExist());
		onView(withText(R.string.menu_show_menu)).perform(click());

	}

	@Test
	public void testNavigationDrawerItemNewImageClick() {
		onView(withId(R.id.drawer_layout)).perform(open());
		onView(withText(R.string.menu_new_image)).perform(click())
				.inRoot(isDialog()).check(matches(isDisplayed()));
	}

	@Test
	public void testNavigationDrawerItemMenuSaveClick() {

		onView(withId(R.id.drawer_layout)).perform(open());
		onView(withText(R.string.menu_save_image)).perform(click());
	}

	@Test
	public void testNavigationDrawerItemMenuCopyClick() {
		onView(withId(R.id.drawer_layout)).perform(open());
		onView(withText(R.string.menu_save_copy)).perform(click());
	}

}
