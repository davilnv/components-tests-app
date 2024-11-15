package br.com.texsistemas.appcomponents.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.texsistemas.appcomponents.R;
import br.com.texsistemas.appcomponents.adapter.BaseAdapter;
import br.com.texsistemas.appcomponents.model.Movie;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private final List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);

        // Listagem de filmes
        loadMovies();

        // Configurar adapter
        BaseAdapter adapter = new BaseAdapter(movieList);

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); // Realiza otimização definindo o mesmo com tamanho fixo
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

    }

    public void loadMovies() {
        movieList.add(new Movie("The Shawshank Redemption", "Drama", "1994"));
        movieList.add(new Movie("The Godfather", "Crime", "1972"));
        movieList.add(new Movie("The Dark Knight", "Action", "2008"));
        movieList.add(new Movie("Forrest Gump", "Drama", "1994"));
        movieList.add(new Movie("Inception", "Science Fiction", "2010"));
        movieList.add(new Movie("Fight Club", "Drama", "1999"));
        movieList.add(new Movie("Pulp Fiction", "Crime", "1994"));
        movieList.add(new Movie("The Matrix", "Science Fiction", "1999"));
        movieList.add(new Movie("The Lord of the Rings: The Return of the King", "Fantasy", "2003"));
        movieList.add(new Movie("Titanic", "Romance", "1997"));
    }

}