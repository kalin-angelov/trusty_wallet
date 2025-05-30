package app.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {

    @NotNull
    private UUID sender;

    @NotNull
    private String receiver;

    @NotNull
    @Positive
    private BigDecimal amount;
}
