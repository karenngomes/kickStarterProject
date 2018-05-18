package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import models.Category;
import models.Comment;
import models.Reward;
import models.User;
import models.projects.Progress;

public class ProgressTest {
	Progress progress;
	User owner;

	@Before
	public void init() {
		owner = new User("test","test@gmail.com","123");
		progress = new Progress(owner,Category.ARTS,"Test","Testing Projects",20,1000.0);
		progress.addReward(new Reward("testing", "description", 20.0, new ArrayList<String>()));
		progress.addReward(new Reward("testing2", "description", 25.0, new ArrayList<String>()));
	}

	@Test
	public void testAddComment() {
		Comment comment = new Comment("Teste", Calendar.getInstance(), owner);
		progress.addComment(comment);
		assertEquals(comment, progress.getListComments().get(progress.getListComments().size()-1));
		
		Comment comment2 = new Comment("Teste2", Calendar.getInstance(), owner);
		progress.addComment(comment2);
		assertEquals(comment2, progress.getListComments().get(progress.getListComments().size()-1));
	}

	@Test
	public void testAddReward() {
		Reward reward = new Reward("test", "description", 15.0, new ArrayList<String>());
		
		progress.addReward(reward);
		assertEquals(reward, progress.getListRewards().get(progress.getListRewards().size()-1));
	}

	@Test
	public void testRemoveReward() {
		Reward reward = progress.getListRewards().get(0);
		
		assertTrue(progress.getListRewards().contains(reward));
		progress.removeReward("testing");
		assertFalse(progress.getListRewards().contains(reward));
	}

}
