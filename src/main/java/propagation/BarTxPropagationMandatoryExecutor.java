package propagation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by qianjia on 2017/1/22.
 */
@Component
public class BarTxPropagationMandatoryExecutor extends BarTxAbstractExecutor {

  public BarTxPropagationMandatoryExecutor(JdbcTemplate jdbcTemplate) {
    super(jdbcTemplate);
  }

  @Transactional(propagation = Propagation.MANDATORY)
  @Override
  public void insert(boolean throwException, String... names) {
    insertInternal(throwException, names);
  }

  @Override
  public Propagation getPropagationMode() {
    return Propagation.MANDATORY;
  }

}
