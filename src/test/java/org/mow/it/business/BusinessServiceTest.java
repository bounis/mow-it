package org.mow.it.business;

import java.net.URISyntaxException;
import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mow.it.domain.Mower;
import org.mow.it.domain.Pelouse;
import org.mow.it.domain.Position;
import org.mow.it.domain.State;
import org.mow.it.domain.StateResolver;
import org.mow.it.exception.UnknownCommandException;
import org.mow.it.util.TestUtil;


public class BusinessServiceTest {

  private static final String INPUT_FILE_PATH = "org/mow/it/business/input-test.txt";

  private static final String BAD_INPUT_TEST_1_TXT = "org/mow/it/business/bad-input-test-1.txt";

  private static final String BAD_INPUT_TEST_2_TXT = "org/mow/it/business/bad-input-test-2.txt";

  private Mower mower1;
  private Mower mower2;


  @BeforeEach
  public void setUp() {
    Position position1 = Position.createPosition("1 3 N");
    State state1 = StateResolver.resolve(position1.getOrientation());
    mower1 = new Mower(position1, state1);
    state1.setMower(mower1);

    Position position2 = Position.createPosition("5 1 E");
    State state2 = StateResolver.resolve(position2.getOrientation());
    mower2 = new Mower(position2, state2);
    state1.setMower(mower2);
  }

  @Test
   public void mowers_should_have_exepected_final_position() throws URISyntaxException {

    BusinessService.getInstance()
        .startMowers(TestUtil.getPathFromRessource(INPUT_FILE_PATH));

    Assertions.assertThat(Pelouse.getInstance().getMowers().size())
        .isEqualTo(2);
    Assertions.assertThat(Pelouse.getInstance().getMowers().get(0).getPosition())
        .isEqualTo(mower1.getPosition());
    Assertions.assertThat(Pelouse.getInstance().getMowers().get(1).getPosition())
        .isEqualTo(mower2.getPosition());
  }

  @Test()
  public void should_throw_no_such_element_exception(){

    Assertions.assertThatThrownBy(() -> {
      BusinessService.getInstance()
          .startMowers(TestUtil.getPathFromRessource(BAD_INPUT_TEST_1_TXT));
    }).isInstanceOf(NoSuchElementException.class);
  }

  @Test()
  public void should_throw_unknown_command_exception(){

    Assertions.assertThatThrownBy(() -> {
      BusinessService.getInstance()
          .startMowers(TestUtil.getPathFromRessource(BAD_INPUT_TEST_2_TXT));
    }).isInstanceOf(UnknownCommandException.class);
  }

}