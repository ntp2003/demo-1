package com.example.demo.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.DivExtractingTagRuleBundle;

public class Configuration extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/**", "templateUser.jsp")

				.addExcludedPath("/admin/**");

		builder.addTagRuleBundles(new DivExtractingTagRuleBundle());

	}

}
