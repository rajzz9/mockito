package org.vardhantrainings.testdoubles.dummy;

public class DummyEmailService implements EmailService {

    @Override
    public void sendEmail(String email) {
        throw new AssertionError("Method not implemented !!!");
    }
}
