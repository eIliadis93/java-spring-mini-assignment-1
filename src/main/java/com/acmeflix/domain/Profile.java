package com.acmeflix.domain;

import com.acmeflix.domain.contentCatalog.Content;
import com.acmeflix.domain.contentCatalog.Language;
import com.acmeflix.domain.contentCatalog.Movie;
import com.acmeflix.domain.contentCatalog.Restrictions;

import java.util.List;

public class Profile extends BaseModel{
    private Restrictions restrictions;
    private String name;
    private Language language;
    private boolean rate;
    private List<Content> mylist;
}
