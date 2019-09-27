package com.yonyou.train.common.id;

public class IdGenerator {
    public static String generateDefaultId(){
        return IdRepository.genId(IdType.ID_TYPE_RANDOM);
    }
    public static String genrateUUID(){
        return IdRepository.genId(IdType.ID_TYPE_UUID);
    }
}
