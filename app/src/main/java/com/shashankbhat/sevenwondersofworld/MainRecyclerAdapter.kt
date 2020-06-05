package com.shashankbhat.sevenwondersofworld

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_layout.view.*

/**
 * Created by SHASHANK BHAT on 05-Jun-20.
 * Shashank Bhat
 * shashankbhat1800@gmail.com
 */

class MainRecyclerAdapter : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {

    private lateinit var mContext: Context
    private var workObjects: ArrayList<Wonders> = ArrayList()

    inner class ViewHolder(@Nullable itemView: View) : RecyclerView.ViewHolder(itemView) {
//        init {
//            itemView.setOnClickListener(this)
//        }
//        override fun onClick(v: View?) {
//            val intent = Intent(mContext, WorkView::class.java)
//            intent.putExtra(Constants.WORK_ID, workObjects[adapterPosition])
//            try {
//                val pair1 = Pair.create(itemView.work_image as View, itemView.resources.getString(R.string.work_image))
//                val pair2 = Pair.create(itemView.work_desc as View, itemView.resources.getString(R.string.work_desc))
//                val pair3 = Pair.create(itemView.work_location as View, itemView.resources.getString(R.string.work_location))
//                val pair4 = Pair.create(itemView.work_what as View, itemView.resources.getString(R.string.what_work))
//
//                val pair5 = Pair.create(itemView.work_sal as View, itemView.resources.getString(R.string.work_salary))
//
//                val pair6 = Pair.create(itemView.work_req_person as View, itemView.resources.getString(R.string.persons_required))
//                val pair7 = Pair.create(itemView.image_location as View, itemView.resources.getString(R.string.image_location))
//                val pair8 = Pair.create(itemView.image_sal as View, itemView.resources.getString(R.string.image_salary))
//                val pair9 = Pair.create(itemView.image_persons as View, itemView.resources.getString(R.string.image_persons))
//
//                val bundle = ActivityOptions.makeSceneTransitionAnimation(mContext as Activity?, pair1, pair2, pair3, pair4,pair5,pair6,pair7,pair8,pair9).toBundle()
//
//                mContext.startActivity(intent, bundle)
//
//            } catch (ex: Exception) {
//                Toast.makeText(mContext,ex.message,Toast.LENGTH_SHORT).show()
//                mContext.startActivity(intent)
//            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return workObjects.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.name.text = workObjects[position].name
        holder.itemView.country.text = workObjects[position].country
        Glide.with(mContext)
            .load(workObjects[position].image)
            .centerCrop()
            .into(holder.itemView.image)
    }

    fun setWorkList(list:ArrayList<Wonders>){
        workObjects = list
        notifyDataSetChanged()
    }

}