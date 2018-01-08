package UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import main.Wrapper;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	WrapperTests.DegenerateTests.class,
	WrapperTests.SplitWordsTests.class,
	WrapperTests.WrapTwoWords.class
})

public class WrapperTests {
	public static class DegenerateTests {

		@Test
		public void wrap_EmptyString_ShouldBeEmpty() throws Exception {
			assertEquals("", Wrapper.wrap("", 1));
		}

		@Test
		public void stringShorterThanColDoesNotWrap() throws Exception {
			assertEquals("word", Wrapper.wrap("word", 10));
		}
	}

	public static class SplitWordsTests {

		@Test
		public void splitOneWord() throws Exception {
			assertEquals("wo\nrd", Wrapper.wrap("word", 2));
		}
		
		@Test
		public void splitOneWordManyTimes() throws Exception {
			assertEquals("abc\ndef\nghi\nj", Wrapper.wrap("abcdefghij", 3));
		}
	}
	
	public static class WrapTwoWords {
		@Test
		public void wrapOnWordBoundary() throws Exception {
			assertEquals("word\nword", Wrapper.wrap("word word", 5));
		}
		
		@Test
		public void wrapAfterWordBoundary() throws Exception {
			assertEquals("word\nword", Wrapper.wrap("word word", 6));
		}
		
		@Test
		public void wrapJustBeforeBondary() throws Exception {
			assertEquals("word\nword", Wrapper.wrap("word word", 4));
		}
		
		@Test
		public void wrapWellBeforeBondary() throws Exception {
			assertEquals("wo\nrd", Wrapper.wrap("word", 2));
		}
	}
}
