package org.example.videostreaming.playload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomMessage {

    private String message;

    private boolean isSucess = false;

}
