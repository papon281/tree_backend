package app.binary.tree.controller;

import app.binary.tree.db.BinaryTreeEntity;
import app.binary.tree.db.BinaryTreeNode;
import app.binary.tree.dto.Numbers;
import app.binary.tree.repository.TreeRepository;
import app.binary.tree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/binary_tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @Autowired
    private TreeRepository treeRepository;

    @PostMapping(value = "/process-numbers",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BinaryTreeEntity processNumbers(@Valid @NotNull @RequestBody Numbers numbers) throws Exception {
        List<Integer> numberList = Arrays.stream(numbers.getNumbers().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        BinaryTreeNode root = treeService.buildTree(numberList);
        String treeStructure = treeService.serializeTree(root);

        BinaryTreeEntity entity = new BinaryTreeEntity();
        entity.setInputNumbers(numbers.getNumbers());
        entity.setTreeStructure(treeStructure);
        treeRepository.save(entity);

        return entity;
    }

    @GetMapping(value = "/previous-trees",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BinaryTreeEntity> getPreviousTrees() {
        return treeRepository.findAll();
    }
}