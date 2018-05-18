package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.Category;
import models.KickStarter;
import models.Project;
import models.User;
import models.projects.Progress;

public class KickStarterTest {
	KickStarter kickStarter;
	
	@Before
	public void init() {
		kickStarter = new KickStarter();
		kickStarter.getListUsers().add(new User("test", "test@gmail.com", "test"));
		kickStarter.getListUsers().add(new User("pedro", "pedro@gmail.com", "123"));
		kickStarter.getListUsers().add(new User("lucas", "lucas@gmail.com", "456"));
		kickStarter.getListProjects().add(new Progress(kickStarter.getListUsers().get(0),Category.ARTS,"Test","Testing Projects",20,1000.0));
	}

	@Test
	public void testGetCurrentUser() {
		assertEquals(null, kickStarter.getCurrentUser());
		assertNotEquals(null,kickStarter.signIn("pedro@gmail.com", "123"));
		assertEquals(null, kickStarter.signIn("pedro@gmail.com", "456"));
	}

	@Test
	public void testSetCurrentUser() {
		User user = kickStarter.signIn("pedro@gmail.com", "123");
		
		kickStarter.setCurrentUser(user);
		assertNotEquals(null, kickStarter.getCurrentUser());
		assertEquals(user, kickStarter.getCurrentUser());
	}


	@Test
	public void testGetProjectByName() {
		Project project = kickStarter.getProjectByName("Test");
		assertNotEquals(null, project);
		assertEquals(kickStarter.getListProjects().get(0), project);
	}

	@Test
	public void testAddUser() {
		kickStarter.addUser("testAdd", "testAdd@gmail.com", "add");
		assertEquals(kickStarter.getListUsers().get(kickStarter.getListUsers().size()-1).getEmail(), "testAdd@gmail.com");
	}

	@Test
	public void testAddProject() {
		Progress project = new Progress(kickStarter.getListUsers().get(1),Category.DESIGN_TECH,"Added","Testing Projects 2",30,2000.0);
		kickStarter.addProject(project);
		
		assertEquals(project,kickStarter.getListProjects().get(kickStarter.getListProjects().size()-1));
	}

	@Test
	public void testSignIn() {
		assertEquals(null, kickStarter.signIn("test", "123"));
		assertEquals(kickStarter.getListUsers().get(0),kickStarter.signIn("test@gmail.com", "test"));
	}

	@Test
	public void testCheckUserByEmail() {
		kickStarter.setCurrentUser(kickStarter.getListUsers().get(0));
		assertTrue(kickStarter.checkUserByEmail("pedro@gmail.com"));
		assertFalse(kickStarter.checkUserByEmail("test@gmail.com"));
	}

	@Test
	public void testGetUserByEmail() {
		User user = kickStarter.getUserByEmail("test@gmail.com");
		assertEquals(kickStarter.getListUsers().get(0),user);
	}

	@Test
	public void testCheckProjectName() {
		assertFalse(kickStarter.checkProjectName("Test"));
		assertTrue(kickStarter.checkProjectName("Added"));
	}

}
