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
        name = "coursApi",
        version = "v1",
        resource = "cours",
        namespace = @ApiNamespace(
                ownerDomain = "backend.servlets",
                ownerName = "backend.servlets",
                packagePath = ""
        )
)
public class CoursEndpoint {

    private static final Logger logger = Logger.getLogger(CoursEndpoint.class.getName());

    private static final int DEFAULT_LIST_LIMIT = 20;

    static {
        // Typically you would register this inside an OfyServive wrapper. See: https://code.google.com/p/objectify-appengine/wiki/BestPractices
        ObjectifyService.register(Cours.class);
    }

    /**
     * Returns the {@link Cours} with the corresponding ID.
     *
     * @param id the ID of the entity to be retrieved
     * @return the entity with the corresponding ID
     * @throws NotFoundException if there is no {@code Cours} with the provided ID.
     */
    @ApiMethod(
            name = "get",
            path = "cours/{id}",
            httpMethod = ApiMethod.HttpMethod.GET)
    public Cours get(@Named("id") Long id) throws NotFoundException {
        logger.info("Getting Cours with ID: " + id);
        Cours cours = ofy().load().type(Cours.class).id(id).now();
        if (cours == null) {
            throw new NotFoundException("Could not find Cours with ID: " + id);
        }
        return cours;
    }

    /**
     * Inserts a new {@code Cours}.
     */
    @ApiMethod(
            name = "insert",
            path = "cours",
            httpMethod = ApiMethod.HttpMethod.POST)
    public Cours insert(Cours cours) {
        // Typically in a RESTful API a POST does not have a known ID (assuming the ID is used in the resource path).
        // You should validate that cours.id has not been set. If the ID type is not supported by the
        // Objectify ID generator, e.g. long or String, then you should generate the unique ID yourself prior to saving.
        //
        // If your client provides the ID then you should probably use PUT instead.
        ofy().save().entity(cours).now();
        logger.info("Created Cours with ID: " + cours.getId());

        return ofy().load().entity(cours).now();
    }

    /**
     * Updates an existing {@code Cours}.
     *
     * @param id    the ID of the entity to be updated
     * @param cours the desired state of the entity
     * @return the updated version of the entity
     * @throws NotFoundException if the {@code id} does not correspond to an existing
     *                           {@code Cours}
     */
    @ApiMethod(
            name = "update",
            path = "cours/{id}",
            httpMethod = ApiMethod.HttpMethod.PUT)
    public Cours update(@Named("id") Long id, Cours cours) throws NotFoundException {
        // TODO: You should validate your ID parameter against your resource's ID here.
        checkExists(id);
        ofy().save().entity(cours).now();
        logger.info("Updated Cours: " + cours);
        return ofy().load().entity(cours).now();
    }

    /**
     * Deletes the specified {@code Cours}.
     *
     * @param id the ID of the entity to delete
     * @throws NotFoundException if the {@code id} does not correspond to an existing
     *                           {@code Cours}
     */
    @ApiMethod(
            name = "remove",
            path = "cours/{id}",
            httpMethod = ApiMethod.HttpMethod.DELETE)
    public void remove(@Named("id") Long id) throws NotFoundException {
        checkExists(id);
        ofy().delete().type(Cours.class).id(id).now();
        logger.info("Deleted Cours with ID: " + id);
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
            path = "cours",
            httpMethod = ApiMethod.HttpMethod.GET)
    public CollectionResponse<Cours> list(@Nullable @Named("cursor") String cursor, @Nullable @Named("limit") Integer limit) {
        limit = limit == null ? DEFAULT_LIST_LIMIT : limit;
        Query<Cours> query = ofy().load().type(Cours.class).limit(limit);
        if (cursor != null) {
            query = query.startAt(Cursor.fromWebSafeString(cursor));
        }
        QueryResultIterator<Cours> queryIterator = query.iterator();
        List<Cours> coursList = new ArrayList<Cours>(limit);
        while (queryIterator.hasNext()) {
            coursList.add(queryIterator.next());
        }
        return CollectionResponse.<Cours>builder().setItems(coursList).setNextPageToken(queryIterator.getCursor().toWebSafeString()).build();
    }

    private void checkExists(Long id) throws NotFoundException {
        try {
            ofy().load().type(Cours.class).id(id).safe();
        } catch (com.googlecode.objectify.NotFoundException e) {
            throw new NotFoundException("Could not find Cours with ID: " + id);
        }
    }
}