package liquibase;

import com.eagerminds.auth.server.AuthServerApplication;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.core.NestedCheckedException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.ConnectException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = AuthServerApplication.class)
public class LiquibaseOauth2ApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultSettings() {
        try {
            AuthServerApplication.main(new String[] { "--server.port=0" });
        } catch (IllegalStateException ex) {
            if (serverNotRunning(ex)) {
                return;
            }
        }
        String output = this.outputCapture.toString();
        assertThat(output).contains("Successfully acquired change log lock")
                .contains("Creating database history table with name: PUBLIC.DATABASECHANGELOG")
                .contains("Table users created")
                .contains("ChangeSet db/changelog/changelog-1/db.changelog-1.0-createSchema.yml::createOAuth2Schema::javierdediego"
                        + " ran successfully")
                .contains("ChangeSet db/changelog/changelog-1/db.changelog-1.0-insertBasicUsers.yml::insertOauth2User::javierdediego"
                        + " ran successfully")
                .contains("New row inserted into users")
                .contains("Successfully released change log lock");
    }

    @SuppressWarnings("serial")
    private boolean serverNotRunning(IllegalStateException ex) {
        NestedCheckedException nested = new NestedCheckedException("failed", ex) {
        };
        if (nested.contains(ConnectException.class)) {
            Throwable root = nested.getRootCause();
            return root.getMessage().contains("Connection refused");
        }
        return false;
    }

}