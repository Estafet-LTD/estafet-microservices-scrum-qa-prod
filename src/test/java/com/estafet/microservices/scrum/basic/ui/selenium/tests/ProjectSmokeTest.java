package com.estafet.microservices.scrum.basic.ui.selenium.tests;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.estafet.microservices.scrum.lib.selenium.pages.project.NewProjectPage;
import com.estafet.microservices.scrum.lib.selenium.pages.project.ProjectBurndownPage;
import com.estafet.microservices.scrum.lib.selenium.pages.project.ProjectListPage;
import com.estafet.microservices.scrum.lib.selenium.pages.project.ProjectPage;
import com.estafet.microservices.scrum.lib.selenium.pages.sprint.SprintBurndownPage;

public class ProjectSmokeTest {

	ProjectListPage projectListPage;

	@Before
	public void before() throws Exception {
		projectListPage = new ProjectListPage();
	}

	@After
	public void after() {
		projectListPage.close();
	}

	@Test
	public void testProject() {
		NewProjectPage newProjectPage = projectListPage.clickNewProjectLink();
		assertTrue(newProjectPage.isLoaded());
		ProjectPage projectPage = newProjectPage.clickSubmitButton();
		assertTrue(projectPage.isLoaded());
		assertThat(projectPage.getStories().size(), is(5));
		ProjectBurndownPage projectBurndownPage = projectPage.clickProjectBurndownLink();
		assertTrue(projectBurndownPage.isLoaded());
		SprintBurndownPage sprintBurndownPage = projectBurndownPage.clickProjectBreadCrumbLink()
				.clickSprintBurndownLink();
		assertTrue(sprintBurndownPage.isLoaded());
	}

}
