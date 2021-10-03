package id.ac.umn.vincent_37401_if570al_uts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {

    private LinkedList<SumberSound> mDaftarSound;
    private LayoutInflater mInflater;
    private Context mContext;

    public LibraryAdapter(Context context, LinkedList<SumberSound> daftarSound){
        this.mDaftarSound = daftarSound;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_sound, parent, false);
        return new LibraryViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SumberSound mSumberSound = mDaftarSound.get(position);
        holder.tvJudul.setText(mSumberSound.getJudul());
        holder.tvKeterangan.setText(mSumberSound.getKeterangan());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDaftarSound.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDaftarSound.size();
    }

    public class LibraryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView soundImg;
        private TextView tvJudul, tvKeterangan;
        private Button btnDelete;
        private SumberSound mSumberSound;
        private int mPosisi;
        private LibraryAdapter mAdapter;

        public LibraryViewHolder(@NonNull View itemView, LibraryAdapter adapter) {
            super(itemView);

            mAdapter = adapter;
            soundImg =(ImageView) itemView.findViewById(R.id.soundImg);
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvKeterangan = (TextView) itemView.findViewById(R.id.tvKeterangan);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            mPosisi = getLayoutPosition();
            mSumberSound = mDaftarSound.get(mPosisi);
            Intent detailIntent = new Intent(mContext, SoundDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("SoundDetail", mSumberSound);
            detailIntent.putExtras(bundle);
            String namaSound = tvJudul.getText().toString();
            detailIntent.putExtra("NamaSound", namaSound);
            mContext.startActivity(detailIntent);
        }
    }
}