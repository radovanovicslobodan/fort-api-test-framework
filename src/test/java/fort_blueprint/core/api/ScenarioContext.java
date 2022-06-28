package fort_blueprint.core.api;

import fort_blueprint.constants.ContextProps.Key;
import io.cucumber.guice.ScenarioScoped;

import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class ScenarioContext {
    private Map<Key<?>, Object> inner = new HashMap<>();

    public <T> T get(Key<T> key) {
        Object raw = inner.get(key);
        @SuppressWarnings("unchecked")
        T typed = (T) raw;
        return typed;
    }

    public <T> void set(Key<T> key, T value) {
        inner.put(key, value);
    }

}
