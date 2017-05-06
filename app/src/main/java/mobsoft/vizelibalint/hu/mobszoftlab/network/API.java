package mobsoft.vizelibalint.hu.mobszoftlab.network;

import java.util.List;

import mobsoft.vizelibalint.hu.mobszoftlab.model.Category;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;
import mobsoft.vizelibalint.hu.mobszoftlab.model.SeqNumber;
import mobsoft.vizelibalint.hu.mobszoftlab.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {

    /**
     * Add SeqNumber to category.
     * This can only be done by the logged in user.
     * @param categoryId Category that needs to be updated.
     * @param body Updated category object.
     * @return Call<List<Company>>
     */

    @PUT("category/add/{categoryId}")
    Call<List<Company>> addSeqNumberToCategory(
            @Path("categoryId") Integer categoryId, @Body Category body
    );


    /**
     * Get Category name from deskID.
     *
     * @param deskId Desk which categorys name is needed.
     * @return Call<Category>
     */

    @GET("category/{deskId}")
    Call<Category> getCategoryNameFromDeskID(
            @Path("deskId") Integer deskId
    );

    /**
     * Returns available companies.
     * Returns an array with company objects.
     * @return Call<List<Company>>
     */

    @GET("companies")
    Call<List<Company>> getCompanies();

    /**
     * Set Desk state active.
     * This can only be done by the logged in user.
     * @param deskId Desk id which state is needed o be modified.
     * @return Call<Void>
     */

    @PUT("desk/activate/{deskId}")
    Call<Void> setDeskStateActive(
            @Path("deskId") Integer deskId
    );

    /**
     *
     * Creates a new SeqNumber.
     * @param seqNumber SeqNumber object that needs to be added.
     * @return Call<SeqNumber>
     */

    @POST("seqnumber")
    Call<SeqNumber> addSeqNumber(
            @Body SeqNumber seqNumber
    );

    /**
     * Set SeqNumber state active.
     * This can only be done by the logged in user.
     * @param seqNumId SeqNumber id which state is needed o be modified.
     * @return Call<Void>
     */

    @PUT("seqnumber/{seqNumId}")
    Call<Void> setSeqNumberStateActive(
            @Path("seqNumId") Integer seqNumId
    );

    /**
     * Deletes a SeqNumber
     *
     * @param seqNumId SeqNumber id to delete
     * @return Call<Void>
     */

    @DELETE("seqnumber/{seqNumId}")
    Call<Void> deleteSeqNumber(
            @Path("seqNumId") Integer seqNumId
    );

    /**
     * Create user
     * This can only be done by the logged in user.
     * @param body Created user object
     * @return Call<Void>
     */

    @POST("register")
    Call<Void> createUser(
            @Body User body
    );

    /**
     * Logs user into the system.
     *
     * @param email The email address for login.
     * @param password The password for login in clear text.
     * @return Call<User>
     */

    @GET("user/login")
    Call<User> loginUser(
            @Query("email") String email, @Query("password") String password
    );

    /**
     * Updated user
     * This can only be done by the logged in user.
     * @param username name that need to be updated
     * @param body Updated user object
     * @return Call<Void>
     */

    @PUT("user/{username}")
    Call<Void> updateUser(
            @Path("username") String username, @Body User body
    );
}
