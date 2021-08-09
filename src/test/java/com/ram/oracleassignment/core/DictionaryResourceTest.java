package com.ram.oracleassignment.core;

import com.ram.oracleassignment.CommonFunctions;
import com.ram.oracleassignment.utils.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class DictionaryResourceTest extends CommonFunctions{

    @Test
    public void testEmptyDic(){
        assertEquals(dictionaryEmpty.getWords().size(), 1) ;
        assertTrue(dictionaryEmpty.getWords().contains(StringUtils.EMPTY_STRING)) ;
    }

    @Test
    public void validateDefaultDic() {
        assertNotNull(dictionaryDefault);
        assertFalse(dictionaryDefault.getWords().isEmpty());
    }

    @Test
    public void validateValidProvidedDic() {
        assertNotNull(dictionaryProvided);
        assertFalse(dictionaryProvided.getWords().isEmpty());
    }

}