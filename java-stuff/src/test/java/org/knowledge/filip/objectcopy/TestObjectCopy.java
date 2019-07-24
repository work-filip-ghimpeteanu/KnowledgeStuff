package org.knowledge.filip.objectcopy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.lang.SerializationUtils;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class TestObjectCopy {

    @Test
    public void whenShallowCopying_thenObjectShouldNotBeSame() {
        Address address = new Address("Nowhere St 10", "NoTown", "NoCountry");
        User johnDoe = new User("John", "Doe", address);

        User shallowCopy = new User(johnDoe.getFirstName(), johnDoe.getLastName(), johnDoe.getAddress());

        // Compares the reference addresses of shallowCopy & johnDoe and not their fields
        assertThat(shallowCopy).isNotSameAs(johnDoe);
    }

    @Test
    public void whenModifyingOriginalObject_ThenCopyShouldChange() {
        Address address = new Address("Nowhere St 10", "NoTown", "NoCountry");
        User johnDoe = new User("John", "Doe", address);

        User shallowCopy = new User(johnDoe.getFirstName(), johnDoe.getLastName(), johnDoe.getAddress());
        address.setCountry("Great Britain");

        assertThat(shallowCopy.getAddress().getCountry()).isEqualTo(johnDoe.getAddress().getCountry());
    }

    @Test
    public void whenModifyingOriginalObject_ThenCopyShouldNotChange() {
        Address address = new Address("Nowhere St 10", "NoTown", "NoCountry");
        User johnDoe = new User("John", "Doe", address);

        User deepCopy = new User(johnDoe);
        address.setCountry("Great Britain");

        assertThat(deepCopy.getAddress().getCountry()).isNotEqualTo(johnDoe.getAddress().getCountry());
    }

    @Test
    public void whenModifyingOriginalObject_thenCloneCopyShouldNotChange() {
        Address address = new Address("Nowhere St 10", "NoTown", "NoCountry");
        User johnDoe = new User("John", "Doe", address);

        User deepCopy = (User) johnDoe.clone();
        address.setCountry("Great Britain");

        assertThat(deepCopy.getAddress().getCountry()).isNotEqualTo(johnDoe.getAddress().getCountry());
    }

    @Test
    public void whenModifyingOriginalObject_thenCommonsCloneShouldNotChange() {
        Address address = new Address("Nowhere St 10", "NoTown", "NoCountry");
        User johnDoe = new User("John", "Doe", address);

        User deepCopy = (User) SerializationUtils.clone(johnDoe);
        address.setCountry("Great Britain");

        assertThat(deepCopy.getAddress().getCountry()).isNotEqualTo(johnDoe.getAddress().getCountry());
    }

    @Test
    public void whenModifyingOriginalObject_thenGsonCloneShouldNotChange() {
        Address address = new Address("Nowhere St 10", "NoTown", "NoCountry");
        User johnDoe = new User("John", "Doe", address);

        Gson gson = new Gson();
        User deepCopy = gson.fromJson(gson.toJson(johnDoe), User.class);
        address.setCountry("Great Britain");

        assertThat(deepCopy.getAddress().getCountry()).isNotEqualTo(johnDoe.getAddress().getCountry());
    }

    @Test
    public void whenModifyingOriginalObject_thenJacksonCopyShouldNotChange() throws IOException {
        Address address = new Address("Nowhere St 10", "NoTown", "NoCountry");
        User johnDoe = new User("John", "Doe", address);

        ObjectMapper objectMapper = new ObjectMapper();
        User deepCopy = objectMapper.readValue(objectMapper.writeValueAsString(johnDoe), User.class);
        address.setCountry("Great Britain");

        assertThat(deepCopy.getAddress().getCountry()).isNotEqualTo(johnDoe.getAddress().getCountry());
    }
}
