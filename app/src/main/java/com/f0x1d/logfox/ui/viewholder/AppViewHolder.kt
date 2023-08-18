package com.f0x1d.logfox.ui.viewholder

import com.bumptech.glide.Glide
import com.f0x1d.logfox.databinding.ItemAppBinding
import com.f0x1d.logfox.extensions.loadIcon
import com.f0x1d.logfox.model.InstalledApp
import com.f0x1d.logfox.ui.viewholder.base.BaseViewHolder

class AppViewHolder(
    binding: ItemAppBinding,
    click: (InstalledApp) -> Unit
): BaseViewHolder<InstalledApp, ItemAppBinding>(binding) {

    init {
        binding.root.setOnClickListener {
            click(currentItem)
        }
    }

    override fun bindTo(data: InstalledApp) {
        binding.icon.loadIcon(data.packageName)

        binding.title.text = data.title
        binding.packageNameText.text = data.packageName
    }

    override fun recycle() = Glide.with(binding.icon).clear(binding.icon)
}