package com.ironman.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Iterator;
import java.util.List;

/**
 * @author jsingh on 2013-06-20 at 2:14 PM
 */
public class PageResource<T> extends ResourceSupport implements Page<T> {

    private final Page<T> page;

    public PageResource(Page<T> page, String pageParam, String sizeParam) {
        super();

        this.page = page;

        if(page.hasPreviousPage()) {
            String path = createBuilder()
                    .queryParam(pageParam, page.getNumber() - 1)
                    .queryParam(sizeParam, page.getSize())
                    .build()
                    .toUriString();
            Link link = new Link(path, Link.REL_PREVIOUS);
            add(link);
        }

        if(page.hasNextPage()) {
            String path = createBuilder()
                    .queryParam(pageParam, page.getNumber() + 1)
                    .queryParam(sizeParam, page.getSize())
                    .build()
                    .toUriString();
            Link link = new Link(path, Link.REL_NEXT);
            add(link);
        }

        Link link = buildPageLink(pageParam, 0, sizeParam, page.getSize(), Link.REL_FIRST);
        add(link);

        int indexOfLastPage = page.getTotalPages() - 1;
        link = buildPageLink(pageParam, indexOfLastPage, sizeParam, page.getSize(), Link.REL_LAST);
        add(link);

        link = buildPageLink(pageParam, page.getNumber(), sizeParam, page.getSize(), Link.REL_SELF);
        add(link);
    }

    private Link buildPageLink(String pageParam, int page, String sizeParam, int size, String rel) {
        String path = createBuilder()
                .queryParam(pageParam, page)
                .queryParam(sizeParam, size)
                .build()
                .toUriString();
        return new Link(path, rel);
    }

    private ServletUriComponentsBuilder createBuilder() {
        return ServletUriComponentsBuilder.fromCurrentRequestUri();
    }
    @Override
    public int getNumber() {
        return page.getNumber();
    }

    @Override
    public int getSize() {
        return page.getSize();
    }

    @Override
    public int getTotalPages() {
        return page.getTotalPages();
    }

    @Override
    public int getNumberOfElements() {
        return page.getNumberOfElements();
    }

    @Override
    public long getTotalElements() {
        return page.getTotalElements();
    }

    @Override
    public boolean hasPreviousPage() {
        return page.hasPreviousPage();
    }

    @Override
    public boolean isFirstPage() {
        return page.isFirstPage();
    }

    @Override
    public boolean hasNextPage() {
        return page.hasNextPage();
    }

    @Override
    public boolean isLastPage() {
        return page.isLastPage();
    }

    @Override
    public Iterator<T> iterator() {
        return page.iterator();
    }

    @Override
    public List<T> getContent() {
        return page.getContent();
    }

    @Override
    public boolean hasContent() {
        return page.hasContent();
    }

    @Override
    public Sort getSort() {
        return page.getSort();
    }
}
