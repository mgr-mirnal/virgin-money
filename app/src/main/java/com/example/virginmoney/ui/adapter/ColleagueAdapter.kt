package com.example.virginmoney.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.virginmoney.databinding.ColleaguesListBinding
import com.example.virginmoney.model.people.PeopleItem

class ColleagueAdapter (
    private val peopleList: MutableList<PeopleItem> = mutableListOf()
    ):RecyclerView.Adapter<ColleagueAdapter.PeopleListViewHolder>(){



        @SuppressLint("NotifyDataChanged")
        fun setPeopleList(newList: List<PeopleItem>, shouldUpdateList: Boolean){
            if (shouldUpdateList) {
                peopleList.addAll(newList)
                notifyItemRangeChanged(0, itemCount)
            } else {
                peopleList.clear()
                peopleList.addAll(newList)
                // works like notifySetChanged, but without the warning
                notifyItemRangeChanged(0, itemCount)
            }
        }

        inner class PeopleListViewHolder(
            private val binding: ColleaguesListBinding
        ): RecyclerView.ViewHolder(binding.root) {
            fun onBind(item: PeopleItem){
                binding.tvFirstName.text = item.firstName
                binding.tvLastName.text = item.lastName
                binding.tvJobTittle.text = item.jobtitle
                Glide.with(binding.ivUserLogo)
                    .load(item.avatar)
                    .into(binding.ivUserLogo)
            }
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleListViewHolder {
            return PeopleListViewHolder(
                ColleaguesListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: PeopleListViewHolder, position: Int) {
            holder.onBind(peopleList[position])
        }

        override fun getItemCount(): Int = peopleList.size


    }