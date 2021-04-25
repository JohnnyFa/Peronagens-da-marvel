package br.com.johnnyfagundes.heroismarvel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import br.com.johnnyfagundes.heroismarvel.R;
import br.com.johnnyfagundes.heroismarvel.model.Result;


public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.myViewHolder> {

    ImageLoader imageLoader = ImageLoader.getInstance();
    private List<Result> heroList;
    String url;

    public HeroAdapter(List<Result> lista) {
        this.heroList = lista;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View herolist = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_hero_list, parent, false);
        return new myViewHolder(herolist);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Result hero = heroList.get(position);
        url = hero.getThumbnail().getPath() + "." + hero.getThumbnail().getExtension();
        url = url.replaceAll(":", "s:");
        holder.mHeroName.setText(hero.getName());

        imageLoader.displayImage(url, holder.mHeroImage);

        System.out.println(url);
    }

    @Override
    public int getItemCount() {
        return Math.min(heroList.size(), 4);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView mHeroName;
        ImageView mHeroImage;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            mHeroName = itemView.findViewById(R.id.txtHeroName);
            mHeroImage = itemView.findViewById(R.id.imgViewHero);
        }
    }


}
