#!/bin/bash

grep '(defproject' project.clj | awk '{print $NF}' | tr -d '"'
