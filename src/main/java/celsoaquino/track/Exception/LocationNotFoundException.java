package celsoaquino.track.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocationNotFoundException extends Exception{

    public LocationNotFoundException(Long id) {
        super(String.format("Person with ID %s not found!", id));
    }

    public LocationNotFoundException() {

    }
}
