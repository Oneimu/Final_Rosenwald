package db.callback;

import org.flywaydb.core.api.callback.Callback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;

public class FlywayCallback implements Callback {

    @Override
    public boolean supports(Event event, Context context) {
        return event.equals(Event.AFTER_EACH_MIGRATE_ERROR);
    }

    @Override
    public boolean canHandleInTransaction(Event event, Context context) {
        return true;
    }

    @Override
    public void handle(Event event, Context context) {
        //TODO handle logic...
    }

    public String getCallbackName() {
        return "Flyway";
    }
}