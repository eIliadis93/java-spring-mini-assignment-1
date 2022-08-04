package com.acmeflix.domain;

import com.acmeflix.domain.program.Language;
import com.acmeflix.domain.program.Restrictions;

public class Profile extends BaseModel{
    private Restrictions restrictions;
    private String name;
    private Language language;
}
