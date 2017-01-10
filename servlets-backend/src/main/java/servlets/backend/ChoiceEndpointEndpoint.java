package servlets.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "choiceEndpointApi",
        version = "v1",
        resource = "choiceEndpoint",
        namespace = @ApiNamespace(
                ownerDomain = "backend.servlets",
                ownerName = "backend.servlets",
                packagePath = ""
        )
)
public class ChoiceEndpointEndpoint {

    private static final Logger logger = Logger.getLogger(ChoiceEndpointEndpoint.class.getName());

    /**
     * This method gets the <code>ChoiceEndpoint</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>ChoiceEndpoint</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getChoiceEndpoint")
    public ChoiceEndpoint getChoiceEndpoint(@Named("id") Long id) {
        // TODO: Implement this function
        logger.info("Calling getChoiceEndpoint method");
        return null;
    }

    /**
     * This inserts a new <code>ChoiceEndpoint</code> object.
     *
     * @param choiceEndpoint The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertChoiceEndpoint")
    public ChoiceEndpoint insertChoiceEndpoint(ChoiceEndpoint choiceEndpoint) {
        // TODO: Implement this function
        logger.info("Calling insertChoiceEndpoint method");
        return choiceEndpoint;
    }
}