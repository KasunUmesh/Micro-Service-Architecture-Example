package lk.ijse.itemservice.util;


import lk.ijse.itemservice.dto.ItemDTO;
import lk.ijse.itemservice.entity.Item;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DataTypeConversion {

    private final ModelMapper modelMapper;

    DataTypeConversion(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

   public ItemDTO getItemDTO(Item item){
        return modelMapper.map(item, ItemDTO.class);
    }
    public Item getItemEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, Item.class);
    }
}
