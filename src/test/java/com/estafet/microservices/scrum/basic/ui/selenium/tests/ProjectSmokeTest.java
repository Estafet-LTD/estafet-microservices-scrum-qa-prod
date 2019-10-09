package com.estafet.microservices.scrum.basic.ui.selenium.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.estafet.microservices.scrum.lib.selenium.pages.project.NewProjectPage;
import com.estafet.microservices.scrum.lib.selenium.pages.project.ProjectBurndownPage;
import com.estafet.microservices.scrum.lib.selenium.pages.project.ProjectListPage;
import com.estafet.microservices.scrum.lib.selenium.pages.project.ProjectPage;

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
		ProjectBurndownPage projectBurndownPage = projectPage.clickProjectBurndownLink();
		assertTrue(projectBurndownPage.isLoaded());
	}

}
