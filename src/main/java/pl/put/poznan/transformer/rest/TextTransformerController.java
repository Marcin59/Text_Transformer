package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.IllegalTransformerNameException;
import pl.put.poznan.transformer.logic.TextTransformerSwitch;
import pl.put.poznan.transformer.logic.textTransformers.BaseTextTransformer;

import java.util.Arrays;


@RestController
@RequestMapping("/")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    // example request: curl -X POST -H "Content-Type: application/json" -d '{"text":"TeSt", "transforms":["Reverse"]}' http://localhost:8080
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<TransformResponse> post(@RequestBody TransformRequest request) {
        String text = request.getText();
        String[] transforms = request.getTransforms();

        // log the parameters
        logger.debug("Received text: " + text);
        logger.debug("Received transforms: " + Arrays.toString(transforms));

        TextTransformerSwitch transformer = new TextTransformerSwitch(new BaseTextTransformer(), transforms);

        TransformResponse response = new TransformResponse(
                HttpStatus.OK.value(),
                "",
                transformer.transform(text)
        );
        logger.debug("Response: " + response.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(IllegalTransformerNameException.class)
    public ResponseEntity<TransformResponse> handleIllegalTransformerNameException(IllegalTransformerNameException e) {
        logger.error(e.getMessage());
        TransformResponse response = new TransformResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                ""
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}


