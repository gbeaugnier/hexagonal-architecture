package fr.gbeaugnier.demo.payload;

import java.math.BigDecimal;

public record AccountRequest(String accountId, BigDecimal amount) {
}
