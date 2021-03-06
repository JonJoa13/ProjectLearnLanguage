package servlets.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Nullable;
import javax.inject.Named;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * WARNING: This generated code is intended as a sample or starting point for using a
 * Google Cloud Endpoints RESTful API with an Objectify entity. It provides no data access
 * restrictions and no data validation.
 * <p>
 * DO NOT deploy this code unchanged as part of a real application to real users.
 */
@Api(
        name = "choiceApi",
        version = "v1",
        resource = "choice",
        namespace = @ApiNamespace(
                ownerDomain = "backend.servlets",
                ownerName = "backend.servlets",
                packagePath = ""
        )
)
public class ChoiceEndpoint {

    private static final Logger logger = Logger.getLogger(ChoiceEndpoint.class.getName());

    private static final int DEFAULT_LIST_LIMIT = 20;

    static {
        // Typically you would register this inside an OfyServive wrapper. See: https://code.google.com/p/objectify-appengine/wiki/BestPractices
        ObjectifyService.register(Choice.class);
    }

    /**
     * Returns the {@link Choice} with the corresponding ID.
     *
     * @param id the ID of the entity to be retrieved
     * @return the entity with the corresponding ID
     * @throws NotFoundException if there is no {@code Choice} with the provided ID.
     */
    @ApiMethod(
            name = "get",
            path = "choice/{id}",
            httpMethod = ApiMethod.HttpMethod.GET)
    public Choice get(@Named("id") Long id) throws NotFoundException {
        logger.info("Getting Choice with ID: " + id);
        Choice choice = ofy().load().type(Choice.class).id(id).now();
        if (choice == null) {
            throw new NotFoundException("Could not find Choice with ID: " + id);
        }
        return choice;
    }

    /**
     * Inserts a new {@code Choice}.
     */
    @ApiMethod(
            name = "insert",
            path = "choice",
            httpMethod = ApiMethod.HttpMethod.POST)
    public Choice insert(Choice choice) {
        // Typically in a RESTful API a POST does not have a known ID (assuming the ID is used in the resource path).
        // You should validate that choice.id has not been set. If the ID type is not supported by the
        // Objectify ID generator, e.g. long or String, then you should generate the unique ID yourself prior to saving.
        //
        // If your client provides the ID then you should probably use PUT instead.
        ofy().save().entity(choice).now();
        logger.info("Created Choice with ID: " + choice.getId());

        return ofy().load().entity(choice).now();
    }

    /**
     * Updates an existing {@code Choice}.
     *
     * @param id     the ID of the entity to be updated
     * @param choice the desired state of the entity
     * @return the updated version of the entity
     * @throws NotFoundException if the {@code id} does not correspond to an existing
     *                           {@code Choice}
     */
    @ApiMethod(
            name = "update",
            path = "choice/{id}",
            httpMethod = ApiMethod.HttpMethod.PUT)
    public Choice update(@Named("id") Long id, Choice choice) throws NotFoundException {
        // TODO: You should validate your ID parameter against your resource's ID here.
        checkExists(id);
        ofy().save().entity(choice).now();
        logger.info("Updated Choice: " + choice);
        return ofy().load().entity(choice).now();
    }

    /**
     * Deletes the specified {@code Choice}.
     *
     * @param id the ID of the entity to delete
     * @throws NotFoundException if the {@code id} does not correspond to an existing
     *                           {@code Choice}
     */
    @ApiMethod(
            name = "remove",
            path = "choice/{id}",
            httpMethod = ApiMethod.HttpMethod.DELETE)
    public void remove(@Named("id") Long id) throws NotFoundException {
        checkExists(id);
        ofy().delete().type(Choice.class).id(id).now();
        logger.info("Deleted Choice with ID: " + id);
    }

    /**
     * List all entities.
     *
     * @param cursor used for pagination to determine which page to return
     * @param limit  the maximum number of entries to return
     * @return a response that encapsulates the result list and the next page token/cursor
     */
    @ApiMethod(
            name = "list",
            path = "choice",
            httpMethod = ApiMethod.HttpMethod.GET)
    public CollectionResponse<Choice> list(@Nullable @Named("cursor") String cursor, @Nullable @Named("limit") Integer limit) {
        limit = limit == null ? DEFAULT_LIST_LIMIT : limit;
        Query<Choice> query = ofy().load().type(Choice.class).limit(limit);
        if (cursor != null) {
            query = query.startAt(Cursor.fromWebSafeString(cursor));
        }
        QueryResultIterator<Choice> queryIterator = query.iterator();
        List<Choice> choiceList = new ArrayList<Choice>(limit);
        while (queryIterator.hasNext()) {
            choiceList.add(queryIterator.next());
        }
        return CollectionResponse.<Choice>builder().setItems(choiceList).setNextPageToken(queryIterator.getCursor().toWebSafeString()).build();
    }

    private void checkExists(Long id) throws NotFoundException {
        try {
            ofy().load().type(Choice.class).id(id).safe();
        } catch (com.googlecode.objectify.NotFoundException e) {
            throw new NotFoundException("Could not find Choice with ID: " + id);
        }
    }
}