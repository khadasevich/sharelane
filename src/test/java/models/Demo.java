package models;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo {

    @Test
    public void checkItemsTest() {
        SignInModel signInModel1 = new SignInModel
                .Builder()
                .username("standard_user")
                .password("secret_sauce")
                .build();
        SignInModel signInModel2 = new SignInModel
                .Builder()
                .username("username")
                .build();
        SignInModel signInModel3 = new SignInModel
                .Builder()
                .password("1234")
                .build();
        Assert.assertEquals(signInModel1, signInModel2);
    }
}
