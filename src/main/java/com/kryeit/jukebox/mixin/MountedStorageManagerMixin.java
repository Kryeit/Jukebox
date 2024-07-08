package com.kryeit.jukebox.mixin;

import com.simibubi.create.content.contraptions.Contraption;
import com.simibubi.create.content.contraptions.MountedStorage;
import com.simibubi.create.content.contraptions.MountedStorageManager;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = MountedStorageManager.class, remap = false)
public class MountedStorageManagerMixin {

	@Inject(
			method = "handlePlayerStorageInteraction",
			at = @At("HEAD")
	)
	private void handlePlayerStorageInteractionMixin(Contraption contraption, Player player, BlockPos localPos, CallbackInfoReturnable<Boolean> cir) {
		if (player.level().isClientSide()) return;
		System.out.println("LEEEEEL");

		StructureTemplate.StructureBlockInfo info = contraption.getBlocks()
				.get(localPos);
		System.out.println("LEEEEEL" + info);
	}
}
