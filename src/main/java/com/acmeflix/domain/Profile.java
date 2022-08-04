package com.acmeflix.domain;

import com.acmeflix.domain.contentCatalog.Language;
import com.acmeflix.domain.contentCatalog.Restrictions;

public class Profile extends BaseModel{
    private Restrictions restrictions;
    private String name;
    private Language language;
}
