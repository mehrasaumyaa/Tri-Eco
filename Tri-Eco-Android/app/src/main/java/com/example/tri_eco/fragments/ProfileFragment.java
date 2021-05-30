package com.example.tri_eco.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tri_eco.DashAdapter;
import com.example.tri_eco.Profile;
import com.example.tri_eco.R;
import com.example.tri_eco.Sell;
import com.example.tri_eco.User;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends Fragment {

    private RecyclerView fragment_dash;
    public static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 42;
    public String photoFileName = "photo.jpg";
    protected DashAdapter adapter;
    protected List<Sell> allPosts;
    public static final String TAG= "ProfileFragment";
    private ImageView ivProfile;
    private TextView tvName;
    private TextView tvCollege;
    private TextView tvEmail;
    private File profilePicture;
    private Button btnSaveProfile;

    public ProfileFragment (){
        //empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // Inflate the layout for this fragment
       return inflater.inflate(R.layout.profile_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragment_dash = view.findViewById(R.id.fragment_dash);

        allPosts = new ArrayList<>();
        adapter = new DashAdapter(getContext(), allPosts);
        //steps to use the recycler view:
        // 0. create layout for one row in the list (recycler view)
        // 1. create the adapter
        // 2. create the data source (which is query posts from ComposeFragment)
        // 3. set the adapter on the recycler view
        fragment_dash.setAdapter(adapter);
        // 4. set the layout manager on the recycler view
        fragment_dash.setLayoutManager(new LinearLayoutManager(getContext()));
        ivProfile = view.findViewById(R.id.ivProfile);
        ivProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                launchCamera();
            }
        });
        tvName = view.findViewById(R.id.tvName);
        btnSaveProfile = view.findViewById(R.id.btnSaveProfile);
        btnSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProfilePicture();
            }
        });
        tvCollege = view.findViewById(R.id.tvCollege);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvName.setText(ParseUser.getCurrentUser().getUsername());
        tvEmail.setText(ParseUser.getCurrentUser().getEmail());
        tvCollege.setText(ParseUser.getCurrentUser().getEmail());
        queryPosts();
    }

    private void launchCamera() {
        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Create a File reference for future access
        profilePicture = getPhotoFileUri(photoFileName);

        // wrap File object into a content provider
        // required for API >= 24
        // See https://guides.codepath.com/android/Sharing-Content-with-Intents#sharing-files-with-api-24-or-higher
        Uri fileProvider = FileProvider.getUriForFile(getContext(), "com.codepath.fileprovider.trieco", profilePicture);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider);

        // If you call startActivityForResult() using an intent that no app can handle, your app will crash.
        // So as long as the result is not null, it's safe to use the intent.
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            // Start the image capture intent to take photo
            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        }
    }

    // Returns the File for a photo stored on disk given the fileName
    private File getPhotoFileUri(String fileName) {
        // Get safe storage directory for photos
        // Use `getExternalFilesDir` on Context to access package-specific directories.
        // This way, we don't need to request external read/write runtime permissions.
        File mediaStorageDir = new File(getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES), TAG);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()){
            Log.d(TAG, "failed to create directory");
        }

        // Return the file target for the photo based on filename
        return new File(mediaStorageDir.getPath() + File.separator + fileName);
    }

    protected void queryPosts() {
        // Specify which class to query
        ParseQuery<Sell> query = ParseQuery.getQuery(Sell.class);
        query.include(Sell.KEY_USER);
        query.whereEqualTo(Sell.KEY_USER, ParseUser.getCurrentUser());
        //limit the number of posts to be displayed
        query.setLimit(20);
        //newest will come first and oldest will be displayed last acc to mentioned key
        query.addDescendingOrder(Sell.KEY_CREATED_AT);

        query.findInBackground(new FindCallback<Sell>() {
            @Override
            public void done(List<Sell> posts, ParseException e) {
                if(e!=null){
                    Log.e(TAG, "Issue with getting posts");
                    return;
                }
                for(Sell post: posts){
                    Log.i(TAG, "Post: "+ post.getTitle());
                    Log.i(TAG, "Price: "+ post.getPrice());
                    Log.i(TAG, "Description: "+ post.getDescription());
                    Log.i(TAG, "Condition: "+ post.getCondition());
                }
                allPosts.addAll(posts);
                adapter.notifyDataSetChanged();

            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // by this point we have the camera photo on disk
                Bitmap takenImage = BitmapFactory.decodeFile(profilePicture.getAbsolutePath());
                // RESIZE BITMAP, see section below
                // Load the taken image into a preview
                //
                ivProfile.setImageBitmap(takenImage);
            } else { // Result was a failure
                Toast.makeText(getContext(), "Picture wasn't taken!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void saveProfilePicture() {
        User user = new User();
//        ParseUser user2 = user.getCurrentUser();
        //User user = User.getCurrentUser();
//        profile.setUser(ParseUser.getCurrentUser());
        user.setProfilePicture(new ParseFile(profilePicture));
//        profile.setEmail(ParseUser.getCurrentUser().getEmail());
        user.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null){
                    Log.e(TAG,"Issue with saving profile picture", e);
                    Toast.makeText(getContext(), "Error saving profile picture", Toast.LENGTH_SHORT).show();
                }
                Log.i(TAG, "Profile picture save was successful");
//                ivProfile.setImageURI();
            }
        });
    }
}
